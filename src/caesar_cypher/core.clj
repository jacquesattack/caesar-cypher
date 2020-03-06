(ns caesar-cypher.core
  (:gen-class))

(defn is-letter [letter]
  (let [int-letter (int letter)]
    (or 
      (and (>= int-letter 65) (<= int-letter 90))
      (and (>= int-letter 97) (<= int-letter 122)))))

(defn not-letter [letter]
  (not (is-letter letter)))

(defn next-letter [letter]
  (let [int-letter (inc (int letter))]
    (cond
      (> int-letter 122) (char 65)
      (and (> int-letter 90) (< int-letter 97)) (char 97)
      :else (char int-letter))))

(defn cypher-map [letter]
  (cond
    (not-letter letter) letter
    :else (next-letter letter)))

(defn cypher [text]
  (apply str (map cypher-map text)))

(defn -main
  "Reads file and prints out text in Caesarian cypher."
  [& args]
  (println (cypher (slurp (first args)))))
