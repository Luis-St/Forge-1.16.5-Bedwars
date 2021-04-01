package net.luis.bedwars.common.item;

import java.util.function.Predicate;

import net.luis.bedwars.Bedwars;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.TippedArrowItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class ModBowItem extends BowItem {

	public ModBowItem() {
		
		super(new Item.Properties().maxDamage(384).group(Bedwars.BEDWARS));
		
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entityLiving, int timeLeft) {
		
		if (entityLiving instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entityLiving;
			int enchInfinity = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack);
			boolean isCreativeOrInfinity = player.abilities.isCreativeMode || enchInfinity > 0;
			ItemStack ammo = player.findAmmo(stack);
			int duration = this.getUseDuration(stack) - timeLeft;
			duration = ForgeEventFactory.onArrowLoose(stack, world, player, duration, !ammo.isEmpty() || isCreativeOrInfinity);
			
			if (duration < 0) {
				
				return;
				
			}
			
			if (!ammo.isEmpty() || isCreativeOrInfinity) {
				
				if (ammo.isEmpty()) {
					
					ammo = new ItemStack(Items.ARROW);
					
				}
				
				float velocityArrow = this.arrowVelocity(duration);
				
				if (!(velocityArrow < 0.1f)) {
					
					if (!world.isRemote) {
						
						AbstractArrowEntity arrowEntity = creatArrowEntity(stack, ammo, world, player, velocityArrow);
						arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
						
						world.addEntity(arrowEntity);
						world.playSound((PlayerEntity) null, player.getPosX(), 
								player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
								1.0F / (random.nextFloat() * 0.4F + 1.2F) + velocityArrow * 0.5F);

						stack.damageItem(2 + random.nextInt(1), player, item -> {
							
							item.sendBreakAnimation(player.getActiveHand());
							
						});
						
					}

					player.addStat(Stats.ITEM_USED.get(this));
					
				}
				
			}
			
		}
		
	}
	
	private AbstractArrowEntity creatArrowEntity(ItemStack stack, ItemStack ammo, World world, PlayerEntity player, float velocity) {
		
		ArrowItem arrowItem = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
		AbstractArrowEntity arrowEntity = arrowItem.createArrow(world, ammo, player);
		arrowEntity = customArrow(arrowEntity);
		arrowEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity * 3.0F, 1.0F);
		
		if (velocity >= 1.0F) {
			
			arrowEntity.setIsCritical(true);
			
		}
		
		double enchPower = getArrowDamage(stack);
		arrowEntity.setDamage(getArrowBaseDamage(ammo) + enchPower);
		
		int enchPunch = getArrowKnockback(stack);
		if (enchPunch > 0) {
			arrowEntity.setKnockbackStrength(enchPunch);	
		}

		arrowEntity.setFire(getArrowFlameTime(stack));
		
		return arrowEntity;
		
	}
	
	public int getArrowBaseDamage(ItemStack ammo) {
		
		int damage = 2;
		
		if (ammo.getItem() instanceof TippedArrowItem) {
			
			damage = 1;
			
		}
		
		return damage;
		
	}

	public float arrowVelocity(int charge) {
		
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		
		if (f > 1.0F) {
			
			f = 1.0F;
			
		}

		return f;
		
	}
	
	public double getArrowDamage(ItemStack stack) {
		
		int enchPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		
		return enchPower * 0.5D + 0.5D;
		
	}
	
	public int getArrowKnockback(ItemStack stack) {
		
		int enchPunch = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
		
		return enchPunch;
		
	}
	
	public int getArrowFlameTime(ItemStack stack) {
		
		int enchFlame = EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack);
		
		return enchFlame * 100;
		
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		
		return 72000;
		
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		
		return UseAction.BOW;
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		ItemStack itemstack = player.getHeldItem(hand);
		boolean hasAmmo = !player.findAmmo(itemstack).isEmpty();

		ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, world, player, hand, hasAmmo);
		
		if (ret != null) {
			
			return ret;
			
		}
			
		if (!player.abilities.isCreativeMode && !hasAmmo) {
			
			return ActionResult.resultFail(itemstack);
			
		} else {
			
			player.setActiveHand(hand);
			return ActionResult.resultConsume(itemstack);
			
		}
		
	}

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		
		return ARROWS;
		
	}

	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		
		return arrow;
		
	}

	public int func_230305_d_() {
		
		return 15;
		
	}
	
}
