(ns ehrd.core
  (:use compojure.core
        ring.middleware.file-info
        ring.middleware.resource
        ring.adapter.jetty
        ring.util.response)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :as compojure])
  (:import [java.io File]
           [org.stringtemplate.v4 ST]))



(def clover-templates (str "clover" File/separatorChar "templates" File/separatorChar))
(def clover-content (str "clover" File/separatorChar "content" File/separatorChar))

(defn- get-template
  "Get template for given uri:
   if the uri.st file is available, return it
   or if there's a default.st in the same path of the uri, return it
   otherwise return site's default.st"
  [uri]
  (let [custom (File. (str clover-templates uri ".st"))
        folder-default (File. (str clover-templates uri File/separatorChar "default.st"))
        site-default (File. (str clover-templates "default.st"))]
    (cond (.exists custom) custom
          (.exists folder-default) folder-default
          :else site-default)))

(defn- get-content
  "Get the content (map) from clover/content/uri.txt, otherwise nil"
  [uri]
  (let [file (File. (str clover-content uri ".txt"))]
    (if (.exists file)
      (let [s (slurp file)]
        ;; This is obviously silly way to process the content, but it works :)
        (into {}  (map (fn [x] (clojure.string/split x #":" 2))
                       (clojure.string/split s #"\n----\n")))))))

(defn- render
  "Returns string - template t with content map cm"
  [t cm]
  (let [st (ST. (slurp t) \$ \$)]
    (doseq [[k v] cm]
      (.add st k v))
    (.render st)))

(defn process-request [{:keys [uri] :as r}]
  (let [uri (if (= "/" uri) "home" uri)
        content (get-content uri)
        template (get-template uri)]
    (if (not (nil? content))
      (render template content)
      (not-found "404 - Not Found"))))

;; routes
(defroutes ehrd-routes
  (route/resources "/")
  (GET "*" []  process-request))

(def ehrd-site
  (handler/site ehrd-routes))

(defn start []
  (run-jetty #'ehrd-site {:port 9099 :join? false}))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty ehrd-site {:port port})))
