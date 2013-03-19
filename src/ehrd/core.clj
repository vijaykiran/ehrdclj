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


(defn process-route [{:keys [uri] :as r}]
  (if-let [uri (if (= "/" uri) "home" uri)]
    (let [f (File. (str "clover" File/separatorChar "content" File/separatorChar uri ".txt"))]
      (if (.exists f)
        (do
          (println (str "processing route: " uri " with file: " (.getAbsolutePath f)
                        " file exists: " (.exists f)))
          (str (slurp f)))
        (not-found "404 - Not Found"))))  )

;; routes
(defroutes ehrd-routes
  (route/resources "/")
  (GET "*" []  process-route))

(def ehrd-site
  (handler/site ehrd-routes))

(defn start []
  (run-jetty #'ehrd-site {:port 9099 :join? false}))
