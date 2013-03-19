(ns ehrd.core
  (:use compojure.core
        ring.middleware.file-info
        ring.middleware.resource
        ring.adapter.jetty
        ring.util.response)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :as compojure])
  (:import java.io.File))


(defn process-request [{:keys [uri] :as r}]
  (let [uri (if (= "/" uri) "home" uri)
        template (File. (str "clover" File/separatorChar "templates" File/separatorChar uri ".st"))]
    (if (.exists template)
      (do
        (println (str "processing route: " uri " with template file: " (.getAbsolutePath template)
                      "template file exists: " (.exists template)))
        (str (slurp template)))
      (not-found "404 - Not Found"))))

;; routes
(defroutes ehrd-routes
  (route/resources "/")
  (GET "*" []  process-request))

(def ehrd-site
  (handler/site ehrd-routes))

(defn start []
  (run-jetty #'ehrd-site {:port 9099 :join? false}))
