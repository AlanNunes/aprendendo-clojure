(ns hospital.aula4
  (:use [clojure pprint]
        [hospital.logica :as h.logica]
        [hospital.model :as h.model]))

(defn chega-em-malvado! [hospital pessoa]
  (swap! hospital h.logica/chega-em :espera pessoa)
  (println "após inserir pessoa" pessoa))

(defn simula-um-dia-em-paralelo-com-mapv []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]]
    (mapv #(.start (Thread. (fn [] (chega-em-malvado! hospital %)))) pessoas)
    (.start (Thread. (fn [] (Thread/sleep 2000)
                       (pprint hospital))))
    )
  )

;(simula-um-dia-em-paralelo-com-mapv)

(defn simula-um-dia-em-paralelo-com-mapv-refatorada []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        starta-thread-de-chegada #(.start (Thread. (fn [] (chega-em-malvado! hospital %))))]
    (mapv starta-thread-de-chegada pessoas)
    (.start (Thread. (fn [] (Thread/sleep 2000)
                       (pprint hospital))))
    )
  )

;(simula-um-dia-em-paralelo-com-mapv-refatorada)

(defn starta-thread-de-chegada
  [hospital pessoa]
  (.start (Thread. (fn [] (chega-em-malvado! hospital pessoa)))))

(defn simula-um-dia-em-paralelo-com-mapv-extraida []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        starta (partial starta-thread-de-chegada hospital)]
    (mapv starta pessoas)
    (.start (Thread. (fn [] (Thread/sleep 2000)
                       (pprint hospital))))
    )
  )

(simula-um-dia-em-paralelo-com-mapv-extraida)

(defn beings-believing
  [person-name feeling]
  (println person-name "is feeling" feeling))

(defn what-a-feeling
  [person-name feeling]
  (beings-believing person-name feeling))

(let [function (partial what-a-feeling "Alan")]
  (mapv function ["happy", "passion", "thrilled", "loved"]))