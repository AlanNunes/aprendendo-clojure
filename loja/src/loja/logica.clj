(ns loja.logica)

(defn conta
  [pedidos]
  (->> pedidos
       (group-by :usuario)
       (vals)
       (map count)))

(defn quantidade-de-pedidos
  [[usuario pedidos]]
  {:usuario usuario
   :total-de-pedidos (count pedidos)})

(defn quantidade-de-pedidos-por-usuario
  [pedidos]
  (->> pedidos
       (group-by :usuario)
       (map quantidade-de-pedidos)))

(defn total-do-item
  [[_ item]]
  (* (get item :quantidade 0) (get item :preco-unitario 0)))

(defn total-do-pedido
  [itens]
  (->> itens
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantidade-de-pedidos-e-valor-total-por-usuario
  [[usuario pedidos]]
  {:usuario usuario
   :quantidade-pedidos (count pedidos)
   :valor-total (total-dos-pedidos pedidos)})

(defn resumo-por-usuario
  [pedidos]
  (->> pedidos
       (group-by :usuario)
       (map quantidade-de-pedidos-e-valor-total-por-usuario)))