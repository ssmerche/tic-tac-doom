(ns tic-tac-doom.benchmark
  (:use [criterium.core] [tic-tac-doom.core :as tic-tac-doom]))

(def empty-board [[:e :e :e] 
                  [:e :e :e] 
                  [:e :e :e]])

(def diag-x [[:x :o :e]
             [:o :x :o]
             [:e :o :x]])

(defn -main [& args]
  (println "\n===With an empty board===")
  (with-progress-reporting (quick-bench (tic-tac-doom/analyze empty-board)))
  (println "\n===With diagonal win for X===")
  (with-progress-reporting (quick-bench (tic-tac-doom/analyze diag-x))))
