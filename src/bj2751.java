import java.io.*;

public class bj2751 {
    public static void main(String[] args) throws IOException {
        // 백준 2751번 수 정렬하기 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr =  new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        mergeSort(arr, 0, n-1);

        for(int i : arr)
            bw.write(i + "\n");

        bw.flush();
        bw.close();
    }

    // 배열 나누기
    static private void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    // 배열 병합, 정렬하기
    static private void merge(int[] arr, int l, int m, int r) {
        int leftSize = m - l + 1;
        int rightSize = r - m;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for(int i=0; i<leftSize; i++)
            leftArr[i] = arr[l + i];
        for(int i=0; i<rightSize; i++)
            rightArr[i] = arr[m + 1 + i];

        int i = 0, j = 0;
        int k = l;
        while(i < leftSize && j < rightSize) {
            if(leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }
        while(i < leftSize)
            arr[k++] = leftArr[i++];
        while(j < rightSize)
            arr[k++] = rightArr[j++];
    }
}
