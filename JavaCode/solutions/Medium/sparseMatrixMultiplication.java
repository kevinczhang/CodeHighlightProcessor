public class Solution {
    /***
     * A sparse matrix can be represented as a sequence of rows,
     * each of which is a sequence of (column-number, value)
     * pairs of the nonzero values in the row.
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];

        List[] indexA = new List[m];
        for (int i = 0; i < m; i++) {
            List<Integer> numsA = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    numsA.add(j);
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }

        for (int i = 0; i < m; i++) {
            List<Integer> numsA = indexA[i];
            for (int p = 0; p < numsA.size() - 1; p += 2) {
                int colA = numsA.get(p);
                int valA = numsA.get(p + 1);
                for (int j = 0; j < nB; j++) {
                    int valB = B[colA][j];
                    result[i][j] += valA * valB;
                }
            }
        }

        return result;
    }

    // Solution 2 using map
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 ||
                B == null || B.length == 0) {
            return new int[0][0];
        }

        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;

        int[][] C = new int[m][l];

        // Step 1: convert the sparse A to dense format
        Map<Integer, Map<Integer, Integer>> denseA = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    if (!denseA.containsKey(i)) {
                        denseA.put(i, new HashMap<>());
                    }
                    denseA.get(i).put(j, A[i][j]);
                }
            }
        }

        // Step 2: convert the sparse B to dense format
        Map<Integer, Map<Integer, Integer>> denseB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                if (B[i][j] != 0) {
                    if (!denseB.containsKey(i)) {
                        denseB.put(i, new HashMap<>());
                    }
                    denseB.get(i).put(j, B[i][j]);
                }
            }
        }

        // Step3: calculate the denseA * denseB
        for (int i : denseA.keySet()) {
            for (int j : denseA.get(i).keySet()) {
                if (!denseB.containsKey(j)) {
                    continue;
                }

                for (int k : denseB.get(j).keySet()) {
                    C[i][k] += denseA.get(i).get(j) * denseB.get(j).get(k);
                }
            }
        }

        return C;
    }
}