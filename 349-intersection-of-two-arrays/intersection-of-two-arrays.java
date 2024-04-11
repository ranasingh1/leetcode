class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int s1 = 0;
        int s2 = 0;
        int e1 = nums1.length - 1;
        int e2 = nums2.length - 1;
        quickSort(nums1, 0, e1);
        quickSort(nums2, 0, e2);
        List<Integer> list = new ArrayList<>();

        while (s1 <= e1 && s2 <= e2) {
            if (nums1[s1] == nums2[s2]) {
                if (!list.contains(nums1[s1])) {
                    list.add(nums1[s1]);
                }
                s1++;
                s2++;
            } else if (nums1[s1] < nums2[s2]) {
                s1++;
            } else {
                s2++;
            }
        }

        // Convert list to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }

        int s = l;
        int e = h;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(arr, l, e);
        quickSort(arr, s, h);
    }
}
