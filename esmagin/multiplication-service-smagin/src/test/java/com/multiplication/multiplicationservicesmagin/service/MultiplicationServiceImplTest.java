package com.multiplication.multiplicationservicesmagin.service;

import com.multiplication.multiplicationservicesmagin.model.MultUser;
import com.multiplication.multiplicationservicesmagin.model.Multiplication;
import com.multiplication.multiplicationservicesmagin.model.MultiplicationAttempt;
import com.multiplication.multiplicationservicesmagin.repository.MultUserRepository;
import com.multiplication.multiplicationservicesmagin.repository.MultiplicationAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class MultiplicationServiceImplTest {
    private MultiplicationService multiplicationService;
    @Mock
    private RandomGeneratorService randomGeneratorService;

    @Mock
    private MultiplicationAttemptRepository multiplicationAttemptRepository;

    @Mock
    private MultUserRepository multUserRepository;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        multiplicationService = new MultiplicationServiceImpl(randomGeneratorService, multiplicationAttemptRepository, multUserRepository);
    }

    @Test
    public void createRandomMultiplication() {
        //given
        given(randomGeneratorService.getRandomFactor()).willReturn(50, 30);

        //when
        Multiplication randomMultiplication = multiplicationService.createRandomMultiplication();

        //then
        assertThat(randomMultiplication.getFactorA(), is(50));
        assertThat(randomMultiplication.getFactorB(), is(30));

    }

    @Test
    public void checkWrongAttempt() {
        Multiplication multiplication = new Multiplication(50, 60);
        MultUser user = new MultUser("Ivan");
        MultiplicationAttempt attempt = new MultiplicationAttempt(user, multiplication, 3010, false);
        given(multUserRepository.findByAlias("Ivan")).willReturn(Optional.empty());

        //when
        boolean res = multiplicationService.checkAttempt(attempt);

        assertFalse(res);
        verify(multiplicationAttemptRepository).save(attempt);
    }

    @Test
    public void checkSuccessAttempt() {
        Multiplication multiplication = new Multiplication(50, 60);
        MultUser user = new MultUser("Ivan");
        MultiplicationAttempt attempt = new MultiplicationAttempt(user, multiplication, 3000, false);
        given(multUserRepository.findByAlias("Ivan")).willReturn(Optional.empty());

        //when
        boolean res = multiplicationService.checkAttempt(attempt);

        assertTrue(res);
        verify(multiplicationAttemptRepository).save(attempt);
    }

    public static void main(String[] args) {
        sortSentence("is2 sentence4 This1 a3");
        numUniqueEmails(new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
    public static String sortSentence(String s) {
        String[] s1 = s.split(" ");
        Map<String,String> res = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            res.put(String.valueOf(s1[i].charAt(s1[i].length() -1)),
                    s1[i].substring(0, s1[i].length() - 1));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            builder.append(res.get(String.valueOf(i+1))).append(" ");
        }
        return builder.substring(0,builder.length()-1);
    }

//    public int deepestLeavesSum(TreeNode root) {
//        getValueOfDeepestRoot( root);
//    }

//    private Integer getValueOfDeepestRoot(TreeNode root) {
//        if(root == null) return 0;
//        if(root.left == null && root.right == null) return root.val;
//    }

//    public List<Integer> partitionLabels(String s) {
//        Map<Character, Integer> res =new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            res.put(s.charAt(i),s.lastIndexOf(s.charAt(i)));
//        }
//
//    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length ; i++) {
            set.add(performEmail(emails[i]));
        }
        return set.size();
    }

    private static String performEmail(String email) {
        String[] split = email.split("@");
        String[] split1 = split[0].split("\\+");
        String replace = split1[0].replace(".", "");
        return replace + "@"+ split[1];
    }
}