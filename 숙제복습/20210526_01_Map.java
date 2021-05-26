package com.day25;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class RemindHomework01 {
	public static void main(String[] args) {
//		< 영단어장 프로그램 >
//		: 영단어(String), 그의 뜻(String)

		Map<String, String> map = new TreeMap<String, String>();

		String choice, word, mean;
		String menu = "1. 단어추가\n2. 모든 단어 보기\n3. 단어 검색\n4. 퀴즈\n0. 종료";

		loop: while (true) {
			choice = JOptionPane.showInputDialog(menu);
			switch (choice) {
			case "1": // 1. 단어 추가
				map.put(JOptionPane.showInputDialog("영단어 입력").toUpperCase(),
						JOptionPane.showInputDialog("뜻 입력").toUpperCase());
				break;
			case "2": // 2. 모든 단어 보기
				if (map.isEmpty()) {
					JOptionPane.showMessageDialog(null, "입력된 단어가 없습니다");
					break;
				}
				Set<String> look = map.keySet();
				StringBuilder sb = new StringBuilder("== 모든 단어 보기 ==");
				for (String s : look) {
					sb.append("\n 영단어 : " + s).append("\n 뜻 : " + map.get(s));
				}
				JOptionPane.showMessageDialog(null, sb);
				break;
			case "3":
//				3. 단어 검색 (영단어 검색)
//				있으면 : 그의 뜻
//				없으면 : 미등록 단어
				word = JOptionPane.showInputDialog("영단어를 입력하세요");
				word = word.toUpperCase();
				if (map.containsKey(word)) {
					JOptionPane.showMessageDialog(null, "입력하신 영단어 : " + word + "\n뜻 : " + map.get(word));
				} else {
					JOptionPane.showMessageDialog(null, "미등록 단어");
				}
				break;
			case "4":
//				4. 퀴즈
//				'뜻(한국어)'을 문제로 내고, 사용자에게 영단어 입력 받기
//				정답/오답 결과 출력
//				예) '사과'(은)는 영어로? ~> apple ~> 정답!
//						~> home ~> 땡..
//						~> 문제는 랜덤하게 나와야함!!!!!!!!
				Object[] arr = map.keySet().toArray();
				int rand = (int) (Math.random() * arr.length);
				String answer;

				word = (String) arr[rand]; // "home"
				mean = map.get(word); // 집
				answer = JOptionPane.showInputDialog(mean + "(은)는 영어로?");

				if (word.equalsIgnoreCase(answer)) {
					JOptionPane.showMessageDialog(null, "정답!");
				} else {
					JOptionPane.showMessageDialog(null, "땡!");
				}
				break;
			case "0": // 0. 종료
				JOptionPane.showMessageDialog(null, "프로그램 종료");
				break loop;
			default:
				JOptionPane.showMessageDialog(null, "잘못된 메뉴");
				break;
			}
		}

	}

}
