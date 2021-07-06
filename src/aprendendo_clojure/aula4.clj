(ns aprendendo-clojure.aula4)

(def precos [30 700 1000])

(defn dobra-valor
  [valor]
  (* valor 2))

(println (precos 0))
(println (update precos 0 dobra-valor))
(println (update precos 0 dobra-valor))