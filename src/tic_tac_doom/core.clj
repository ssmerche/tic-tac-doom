(ns tic-tac-doom.core)

(defn column-sets [board]
  (for [i (range (count board))] 
    (set (map #(% i) board))))

(def row-sets (partial map set))

(defn winner [sets]
  (->> sets (map {#{:x} :x, #{:o} :o}) (remove nil?) first))

(defn diag-sets [board]
  [(set (map #(%1 %2) board (range (count board)))) 
   (set (map #(%1 %2) board (reverse (range (count board)))))])

(defn analyze
  "Determine the winner of a game of tic-tac-toe."
  [board]
  (->> (map winner [(column-sets board) (row-sets board) (diag-sets board)]) 
    (remove nil?) first))
