(ns loja.core)

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (when (not (nil? primeiro))
      (println primeiro)
      (recur funcao (rest sequencia)))))

(meu-mapa println ["alan" "karynne" "luan" "tainan"])
(meu-mapa println (range 10000))