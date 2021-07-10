(ns aprendendo-clojure.aula6)

(def pedido {:mochila {:quantidade 10, :preco 40}
             :cadeira {:quantidade 5, :preco 100}})

(defn imprime-15 [[chave valor]]
  valor)

(println (map imprime-15 pedido))

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))




(defn preco-dos-produtos
  [produto]
  (* (:quantidade produto) (:preco produto)))

; THREAD LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-dos-produtos)
       (reduce +)))

(println "Total do pedido com THREAD LAST:" (total-do-pedido pedido))

(def pedido {:mochila {:quantidade 10, :preco 40}
             :cadeira {:quantidade 5, :preco 100}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [[_ valor]]
  (<= (get valor :preco 0) 0))

(println "Filtrando pedidos gratuitos" (filter gratuito? pedido))

(defn gratuito?
  [produto]
  (<= (get produto :preco 0) 0))

(println "Filtrando pedidos gratuitos" (filter (fn [[_ valor]] (gratuito? valor)) pedido))
(println "Filtrando pedidos gratuitos" (filter #(gratuito? (second %)) pedido))

(defn pago?
  [produto]
  (not (gratuito? produto)))

(println (pago? {:preco 0}))

(def pago? (comp not gratuito?))

(println (pago? {:preco 0}))
(println (pago? {:preco 25}))

(println "Filtra itens pagos" (filter #(pago? (second %)) pedido))
