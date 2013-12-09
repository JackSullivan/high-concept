(ns so.modernized.high-concept.core)


; Trident performs the following transformation:
; ((trident f1 f2 f3) n) -> (f2 (f1 n) (f3 n))
(defn trident [f1 f2 f3]
  (fn [n]
    (f2
     (f1 n)
     (f3 n))))

; Zip performs the following transformation:
; (zip (a b c) (1 2 3)) -> ((a 1) (b 2) (c 3))
(def zip (partial map vector))

; Unzip performs the following transformation:
; (unzip ((a 1) (b 2) (c 3))) -> (a b c) (1 2 3)
(defn unzip
  [coll]
  (map (fn [idex]
         (map #(nth % idex) coll))
       (-> coll first count range)))
