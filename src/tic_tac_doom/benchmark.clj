(ns tic-tac-doom.benchmark
  (:require [criterium.core :as bench] [tic-tac-doom.ssmerche :as ssmerche] [tic-tac-doom.jon :as jon]
            [tic-tac-doom.jimmy :as jimmy]))

(def empty-board [[:e :e :e] 
                  [:e :e :e] 
                  [:e :e :e]])

(def diag-x [[:x :o :e]
             [:o :x :o]
             [:e :o :x]])

(defn benchmark [name fn]
  (println (str "\n\n" name " benchmark"))
  (println "\nWith an empty board")
  (bench/quick-bench (fn empty-board))
  (println "\nWith diagonal win for X")
  (bench/quick-bench (fn diag-x)))

(defn -main [& args]
  (benchmark "jon's" jon/analyze)
  (benchmark "ssmerche's" ssmerche/analyze)
  (benchmark "jimmy's" jimmy/analyze))
