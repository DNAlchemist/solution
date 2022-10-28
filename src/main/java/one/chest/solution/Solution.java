package one.chest.solution;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static long calculateWaterAmount(int[] landscape) {
        List<Pair> pairList = new ArrayList<>(landscape.length);
        for (int i = 0; i < landscape.length; i++) {
            assert landscape[i] >= 0;
            pairList.add(new Pair(i, landscape[i]));
        }
        pairList.sort(Comparator.<Pair>comparingInt(o -> o.height).reversed());

        long result = 0;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        for (int i = 1; i < pairList.size(); i++) {
            Pair current = pairList.get(i);
            Pair prev = pairList.get(i - 1);

            var minPos = Math.min(current.index, prev.index);
            var maxPos = Math.max(current.index, prev.index);
            if (minPos < l) {
                maxPos = Math.min(maxPos, l);
            } else {
                minPos = Math.max(minPos, r);
            }
            int spaceCount = maxPos - minPos - 1;
            boolean isUnderwater = minPos >= l && maxPos <= r;
            if (spaceCount == 0 || isUnderwater) {
                continue;
            }
            int maxHeight = Math.min(current.height, prev.height);
            result += (long) maxHeight * spaceCount;
            for (int j = 1; j <= spaceCount; j++) {
                result -= Math.min(maxHeight, landscape[minPos + j]);
            }
            l = Math.min(l, minPos);
            r = Math.max(r, maxPos);
        }

        return result;
    }
}