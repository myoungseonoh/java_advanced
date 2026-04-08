package securecoding.codeerror;

import java.util.Optional;

public class Nullable {

    public static String findUserName(boolean exists) {
        if (exists) {
            return "BTS";
        }
        return null; // 호출자가 null 체크를 잊으면 NPE 발생
    }

    public static Optional<String> findUserNameSafe(boolean exists) {
        if (exists) {
            return Optional.of("BTS");
        }
        return Optional.empty(); // null 대신 빈 Optional 반환
    }

    public static void main(String[] args) {

        // [1] null 반환
        System.out.println("\n--  Null 반환 방식 --");

        String name = findUserName(false);

        // null 체크를 깜빡하면 아래 줄에서 NullPointerException!
        // System.out.println(name.toUpperCase()); // ← NPE 발생

        // 방어적으로 사용하려면 매번 null 체크 필요
        if (name != null) {
            System.out.println("사용자: " + name.toUpperCase());
        } else {
            System.out.println("사용자 없음 (null)");
        }

        // [2] Optional 방식
        System.out.println("\n--  Optional 반환 방식 --");

        Optional<String> optName = findUserNameSafe(false);

        // isPresent() / isEmpty() 로 존재 여부 확인
        if (optName.isPresent()) {
            System.out.println("사용자: " + optName.get().toUpperCase());
        } else {
            System.out.println("사용자 없음 (Optional.empty)");
        }

        // orElse() : 값이 없을 때 기본값 제공
        String result1 = findUserNameSafe(false).orElse("익명");
        System.out.println("orElse    → " + result1);

        // orElseGet() : 값이 없을 때 람다로 기본값 생성
        String result2 = findUserNameSafe(false).orElseGet(() -> "Guest_" + System.currentTimeMillis());
        System.out.println("orElseGet → " + result2);

        // ifPresent() : 값이 있을 때만 동작 수행
        findUserNameSafe(true).ifPresent(n -> System.out.println("ifPresent → " + n));

        // orElseThrow() : 값이 없으면 명시적 예외 발생 (NPE보다 의도가 명확)
        try {
            String result3 = findUserNameSafe(false).orElseThrow(() -> new IllegalStateException("사용자를 찾을 수 없습니다."));
        } catch (IllegalStateException e) {
            System.out.println("orElseThrow → " + e.getMessage());
        }
    }
}
