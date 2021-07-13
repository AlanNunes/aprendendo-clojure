(ns loja.db)

(def pedido1 {:usuario 15
              :itens {:mochila { :id :mochila, :quantidade 2, :preco-unitario 80}
                       :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                       :tenis    { :id :tenis, :quantidade 1}}})

(def pedido2 {:usuario 15
              :itens {:mochila { :id :mochila, :quantidade 2, :preco-unitario 80}
                       :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                       :tenis    { :id :tenis, :quantidade 1}}})

(def pedido3 {:usuario 25
              :itens {:mochila { :id :mochila, :quantidade 2, :preco-unitario 50}
                       :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 10}
                       :tenis    { :id :tenis, :quantidade 1}}})

(def pedido4 {:usuario 15
              :itens {:mochila { :id :mochila, :quantidade 2, :preco-unitario 50}
                       :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                       :tenis    { :id :tenis, :quantidade 1}}})

(def pedido5 {:usuario 35
              :itens {:mochila { :id :mochila, :quantidade 2, :preco-unitario 70}
                       :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 20}
                       :tenis    { :id :tenis, :quantidade 1}}})

(def pedido6 {:usuario 25
              :itens {:mochila { :id :mochila, :quantidade 2, :preco-unitario 100}
                       :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 70}
                       :tenis    { :id :tenis, :quantidade 1}}})

(defn todos-os-pedidos []
  [pedido1, pedido2, pedido3, pedido4, pedido5, pedido6])