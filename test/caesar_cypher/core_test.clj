(ns caesar-cypher.core-test
  (:require [clojure.test :refer :all]
            [caesar-cypher.core :refer :all]))

(deftest not-letter-test
  (testing "not letter"
    (is (= (not-letter \space ) true)))
  (testing "is letter"
    (is (= (is-letter \a) true)))
  (testing "is capital letter"
    (is (= (is-letter \A) true))))

(deftest next-letter-test
  (testing "A"
    (is (= (next-letter \A) \B)))
  (testing "Z"
    (is (= (next-letter \Z) \a)))
  (testing "z"
    (is (= (next-letter \z) \A))))

(deftest cypher-test
  (testing "cypher test"
    (is (= (cypher "foo bar!") "gpp cbs!")))
  (testing "cypher test"
    (is (= (cypher "Zz") "aA"))))
