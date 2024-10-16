class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        """
        result = []
        std = max(candies)
        for i in candies:
            if std <= i + extraCandies:
                result.append(True)
            else:
                result.append(False)
        return result
