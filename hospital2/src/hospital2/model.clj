(ns hospital2.model)

(defprotocol Dateable
  (to-ms [this]))

(extend-type java.lang.Number
  Dateable
  (to-ms [this] this))

;(println (to-ms 777))

(extend-type java.util.Date
  Dateable
  (to-ms [this] (.getTime this)))

;(println (to-ms (java.util.Date.)))

(extend-type java.util.Calendar
  Dateable
  (to-ms [this] (to-ms (.getTime this))))