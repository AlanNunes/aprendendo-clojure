# Aprendendo Clojure

Neste repositório tem algumas atividades feitas durante um curso de Clojure para aprender o paradigma funcional.

# Algumas funções criadas
## Contador
```clojure
(defn conta
  ([elementos] (conta 0 elementos))
  ([valor elementos]
   (if (seq elementos)
     (recur (inc valor) (next elementos))
     valor)))

(println (conta 0 ["alan" "karynne" "luan" "tainan" "joãozinho" "thalita"]))
```

Contador utilizando a função loop.

```clojure
(defn conta
  [elementos]
  (loop
    [valor 0
     elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc valor) (next elementos-restantes))
      valor)))

(println (conta ["alan" "karynne" "luan" "tainan" "joãozinho" "thalita"]))
```

## Meu mapa (uma iteração utilizando Tail Recursion)

Esta função simula a função ```map```.
```clojure
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (when (not (nil? primeiro))
      (println primeiro)
      (recur funcao (rest sequencia)))))

(meu-mapa println ["alan" "karynne" "luan" "tainan"])
(meu-mapa println (range 10000))
```

## Utilizando defmulti e defmethod

```clojure
(defmulti hello-world
          (fn [[id lang]] (get lang :name)))

(defmethod hello-world "C#" [params]
  (println "System.Console.WriteLine(\"Hello World!\")"))

(defmethod hello-world "Python" [params]
  (println "print(\"Hello World!\")"))

(defmethod hello-world "Javascript" [params]
  (println "console.log(\"Hello World!\")"))

(defmethod hello-world "Clojure" [params]
  (println "(println \"Hello World!\")"))
```
