(ns tic-tac-doom.ssmerche)

(defn column-sets [board]
  (for [i (range (count board))] (set (map #(% i) board))))

(def row-sets (partial map set))

(defn diagonal-sets [board]
  [(set (map #(%1 %2) board (range (count board)))) 
   (set (map #(%1 %2) board (reverse (range (count board)))))])

(def board-sets (juxt column-sets row-sets diagonal-sets))

(defn find-winner [sets] (->> sets (filter #{#{:x} #{:o}}) ffirst))

(defn analyze
  "Determine the winner of a game of tic-tac-toe."
  [board]
  (->> (board-sets board) (map find-winner) (remove nil?) first))
