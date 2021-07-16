(ns hospital.colecoes
  (:use [clojure pprint]))

(defn testa-vetor []
  (let [espera [111 222]]
    (println espera)
    (println (conj espera 333))
    (println (pop espera)))
  )

(defn testa-lista []
  (let [espera '(111 222)]
    (println espera)
    (println (conj espera 333))
    (println (pop espera)))
  )

(defn testa-conjunto []
  (let [espera #{111 222}]
    (println espera)
    (println (conj espera 111)))
  )

(defn testa-fila []
  (let [espera (conj clojure.lang.PersistentQueue/EMPTY 111 222)]
    (pprint espera)
    (pprint (conj espera 333))
    (println (peek espera)))
  )

(println "Testa vetor")
(testa-vetor)
(println "Testa lista")
(testa-lista)
(println "Testa conjunto")
(testa-conjunto)
(println "Testa fila")
(testa-fila)