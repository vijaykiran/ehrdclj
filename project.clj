(defproject ehrd "0.1.0-SNAPSHOT"
  :description "Website for Rotterdam/The Hague Meetup"
  :url "http://www.ehrdclj.org/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[compojure "1.1.5"]
                 [enlive "1.0.1"]
                 [markdown-clj "0.9.19"]
                 [org.antlr/ST4 "4.0.7"]
                 [org.clojure/clojure "1.5.1"]
                 [ring "1.1.8"]]
  :pom-addition [:developers [:developer {:id "vijaykiran"}
                              [:name "Vijay Kiran"]
                              [:url "http://vijaykiran.com"]]])
