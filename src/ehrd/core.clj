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

(defn- template-file
  "Get the template file for path if exists, otherwise nil."
  [file-name]
  (let [f (File. (str clover-templates File/separatorChar file-name ".st"))]
    (if (.exists f) f)))


(defn- get-template
  "Get the template for a uri of the form '/x/y/z:'
  in the order of availability pick the /x/y/z.st or x/y/default.st otherwise,
  /x/y.st or /x/default.st and so on."
  [path]
  (loop [components (clojure.string/split path #"/")]
    (let [cf (first (rseq components))
          cp (clojure.string/join "/" (drop-last components))
          tf (template-file (str cp File/separatorChar cf))
          df (template-file (str cp File/separatorChar "default"))]
      (cond (not (nil? tf)) tf
            (not (nil? df)) df
            :else (recur (vec (drop-last components)))))))

(defn- get-content-map
  "get the key/values from file.txt"
  [file]
  (let [s (slurp file)]
    ;; This is obviously silly way to process the content, but it works :)
    (into {}  (map (fn [x] (clojure.string/split x #":" 2))
                   (clojure.string/split s #"\n----\n")))))

(defn- get-common-content
  "Get the key-values from _common.txt "
  []
  (get-content-map (File. (str clover-content "_common.txt"))))

(defn- get-content
  "Get the content (map) from clover/content/uri.txt merged with _common.txt content"
  [uri]
  (let [file (File. (str clover-content uri ".txt"))
        content (get-common-content)]
    (if (.exists file)
      (merge content (get-content-map file)))))

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
