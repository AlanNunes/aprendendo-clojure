(ns loja.core)

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)
        resto (rest sequencia)]
    (when (> (count resto) 0)
      (meu-mapa funcao resto)
      (println primeiro))))

(meu-mapa println ["alan" "karynne" "luan" "tainan"])