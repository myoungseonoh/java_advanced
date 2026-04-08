package solid.dip;
import java.util.Random;

/**
 * 공격 인터페이스
 */
interface Attackable
{
	/**
	 * 공격 추상 함수
	 */
	int attack();
	
	/**
	 * 객체 문자열 반환 추상 함수
	 */
	@Override
	String toString();
}

/**
 * 한손무기 객체
 */
class OneHandWeapon2 implements Attackable
{
	private final String NAME;
	private final int DAMAGE;
	
	/**
	 * OneHandWeapon2 생성자 함수
	 */
	public OneHandWeapon2(String name, int damage)
	{
		NAME = name;
		DAMAGE = damage;
	}
	
	/**
	 * 공격 데미지 반환 함수
	 */
	@Override
	public int attack()
	{
		return DAMAGE + new Random().nextInt(10) - 5;
	}
	
	/**
	 * 객체 문자열 반환 함수
	 */
	@Override
	public String toString()
	{
		return NAME;
	}
}

/**
 * 한손무기 객체
 */
class TwoHandWeapon2 implements Attackable {
	
	private final String NAME;
	private final int DAMAGE;
	
	/**
	 * TwoHandWeapon2 생성자 함수
	 */
	public TwoHandWeapon2(String name, int damage)
	{
		NAME = name;
		DAMAGE = damage;
	}
	
	/**
	 * 공격 데미지 반환 함수
	 */
	@Override
	public int attack()
	{
		return DAMAGE + new Random().nextInt(10) - 5;
	}
	
	/**
	 * 객체 문자열 반환 함수
	 */
	@Override
	public String toString()
	{
		return NAME;
	}
}

/**
 * 캐릭터 객체
 *
 */
class Character2
{
	private final String NAME;
	private int health;
	private Attackable weapon;
	
	/**
	 * Character 생성자 함수
	 *
	 * @param name: [String] 이름
	 * @param health: [int] 체력
	 * @param weapon: [Attackable] 무기
	 */
	public Character2(String name, int health, Attackable weapon)
	{
		NAME = name;
		this.health = health;
		this.weapon = weapon;
	}
	
	/**
	 * 공격 데미지 반환 함수
	 *
	 * @return [int] 공격 데미지
	 */
	public int attack()
	{
		return weapon.attack();
	}
	
	/**
	 * 피격 함수
	 *
	 * @param amount: [int] 피격 데미지
	 */
	public void damaged(int amount)
	{
		health -= amount;
	}
	
	/**
	 * 무기 교체 함수
	 *
	 * @param weapon: [Attackable] 무기
	 */
	public void chageWeapon(Attackable weapon)
	{
		this.weapon = weapon;
	}
	
	/**
	 * 캐릭터 정보 출력 함수
	 */
	public void getInfo()
	{
		System.out.println("이름: " + NAME);
		System.out.println("체력: " + health);
		System.out.println("무기: " + weapon);
	}
}

public class Play2 {

	final static void main(String[] args) {
		
		// 구현체가 아닌 Attackable 인터페이스를 참조
		Character2 player1 = new Character2("캐릭터", 100, new OneHandWeapon2("도끼", 30));
		player1.chageWeapon(new TwoHandWeapon2("활", 15));
		
		// 두손무기 추가시... 
		// 두손무기 클래스 TwoHandWeapon2를 Attackable 구현하여 만들어서 설정하면 끝.
		Character2 player2 = new Character2("캐릭터", 100, new TwoHandWeapon2("활", 15));
	}
}
