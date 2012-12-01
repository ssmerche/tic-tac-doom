(ns tic-tac-doom.jimmy)

(defn winners
  [rows]
  (map (fn [row] (if (apply = row) (first row) nil)) rows))

(defn check-veritcals
  [board]
  (winners (partition (count board) (apply interleave board))))

(defn check-diagonals
  [board]
  (winners 
    [(for [i (range (count board))] (nth (nth board i) i)) 
      (for [i (range (count board))] (nth (reverse (nth board i)) i))]))

(defn analyze
  [board]
  (let
    [possible-winners (flatten (list (winners board) (check-veritcals board) (check-diagonals board)))]
    (first (filter #(not= :e %) (filter (comp not nil?) possible-winners)))))
