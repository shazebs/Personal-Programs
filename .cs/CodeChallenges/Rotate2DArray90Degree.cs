public static void Rotate(int[][] matrix)
        {
            int size = matrix.Length;
            int it = size - 1;
            List<int[]> slices = new List<int[]>();
            while (it > -1)
            {
                int[] slice = matrix[it--].ToArray();
                slices.Add(slice);
            }
            it = 0;
            while (it < size) /* column loop */
            {
                for (var r = 0; r < size; r++)
                { /* row loop */
                    matrix[r][it] = slices[it][r];
                    // slices.RemoveAt(0);
                }
                it++;
            }
        }
