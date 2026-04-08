package solid.dip;

import java.util.Random;

/**
 * 한손검 객체
 */
class OneHandWeapon
{
	private final String NAME;
	private final int DAMAGE;
	
	/**
	 * OneHandWeapon 생성자 함수
	 */
	public OneHandWeapon(String name, int damage)
	{
		NAME = name;
		DAMAGE = damage;
	}
	
	/**
	 * 공격 데미지 반환 함수
	 */
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
 */
class Character
{
	private final String NAME;
	private int health;
	private OneHandWeapon weapon;
	
	/**
	 * Character 생성자 함수
	 *
	 * @param name: [String] 이름
	 * @param health: [int] 체력
	 * @param weapon: [OneHandSword] 무기
	 */
	public Character(String name, int health, OneHandWeapon weapon)
	{
		NAME = name;
		this.health = health;
		this.weapon = weapon;
	}
	
	/**
	 * 공격 데미지 반환 함수
	 */
	public int attack()
	{
		return weapon.attack();
	}
	
	/**
	 * 무기 교체 함수
	 */
	public void chageWeapon(OneHandWeapon weapon)
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

public class Play1 {

	final static void main(String[] args) {
		
		Character player1 = new Character("캐릭터", 100, new OneHandWeapon("도끼", 30));
		
		// 다른 무기를 설정하려고 하려면.. 무기 클래스 정의 및 Character 클래스를 수정해야 함 
	}
	
}
