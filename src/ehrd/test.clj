(def ehrd.clj
  {:description "Rotterdam The Hague Clojure Meetup"
   :frequency :monthly
   :date (last (filter #(= WEDNESDAY %) current-month))
   :time "19:00"
   :agenda ["Library of the month",
            "This month in Clojure",
            "Hackathons", "Food", "Drinks"]
   :location "Lunatech, Rotterdam"
   :organizers ["@vijaykiran", "@minleychris"]})
