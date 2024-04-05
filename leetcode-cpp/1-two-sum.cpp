#include <iostream>
#include <vector>
#include <unordered_map>

class Solution {
public:
	std::vector<int> twoSum(std::vector<int>& nums, int target) {
		std::unordered_map<int, int> map;
		for (int i = 0; i < nums.size(); ++i) {
			auto it = map.find(target - nums[i]);
			if (it != map.end()) {
				return {it->second, i};
			}
			map[nums[i]] = i;
		}
		return std::vector<int>{};
	}
};

void printSolution(const std::vector<int>& nums) {
	std::cout << "[";
	for (int i = 0; i < nums.size(); ++i) {
		if (i != 0) {
			std::cout << ", ";
		}
		std::cout << nums[i];
	}
	std::cout << "]" << std::endl;
}

int main() {
	Solution solution;
	// example 1
	std::vector<int> nums {2,7,11,15};
	int target {9};
	printSolution(solution.twoSum(nums, target)); // [0, 1]

	// example 2
	std::vector<int> nums2 {3,2,4};
	target = 6;
	printSolution(solution.twoSum(nums2, target)); // [1, 2]

	// example 3
	std::vector<int> nums3 {3,3};
	printSolution(solution.twoSum(nums3, target)); // [0, 1]

	return 0;
}