package daily.oct24;

import java.util.Arrays;

public class Day4DividePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long chemistry = 0;
        int l = 0, r = skill.length - 1, sumReq = skill[l] + skill[r];
        while (l <= r) {
            int currentSum = skill[l] + skill[r];
            if (currentSum != sumReq) return -1;
            chemistry += ((long) skill[l] * skill[r]);
            l++;
            r--;
        }

        return chemistry;
    }

    public long dividePlayersOptimised(int[] skill) {
        int[] skills = new int[1001];
        int totalSkill = 0;
        for(int playerSkill : skill) {
            skills[playerSkill]++;
            totalSkill += playerSkill;
        }

        if(totalSkill % (skill.length/2) != 0) return -1;

        long chemistry = 0;
        int skillReq = totalSkill / (skill.length/2);
        for(int playerSkill : skill) {
            int req = skillReq - playerSkill;
            if(skills[req] < 0) return -1;

            chemistry += ((long) playerSkill * req);
            skills[req]--;
        }

        return chemistry;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4};
        Day4DividePlayersIntoTeamsOfEqualSkill obj = new Day4DividePlayersIntoTeamsOfEqualSkill();
        System.out.println(obj.dividePlayersOptimised(arr));
    }
}
