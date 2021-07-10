(ns aprendendo-clojure.aula5)

(def estoque {:Mochila 10, :Camisa 20})

(println (assoc estoque :Casaco 7))
(println (dissoc estoque :Camisa))
(println (update estoque :Camisa dec))
(println (keys estoque))
(println (vals estoque))


(def pedido {:mochila {:quantidade 10, :preco 40}
             :cadeira {:quantidade 5, :preco 100}})

(println "Preço da mochila do pedido:" (:preco (:mochila pedido)))
(println "Quantidade da mochila do pedido:" (:quantidade (:mochila pedido)))
(println "Estoque depois de atualizado:" (update-in pedido [:cadeira :quantidade] dec))

; Threading First
(println "Quantidade de mochilas usando Threading First:" (-> pedido
             :mochila
             :quantidade))