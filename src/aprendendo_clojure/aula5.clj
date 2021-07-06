(ns aprendendo-clojure.aula5)

(def estoque {:Mochila 10, :Camisa 20})

(println (assoc estoque :Casaco 7))
(println (dissoc estoque :Camisa))
(println (update estoque :Camisa dec))
(println (keys estoque))
(println (vals estoque))