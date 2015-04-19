package jeckelmiscmod.content.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockShower extends Block
{
	public BlockShower(String modId, String blockName)
	{
		super(Material.rock);
        this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeStone);
		this.setBlockName(blockName);
		this.setBlockTextureName(modId + ":" + blockName.replace(".", "/"));
        this._iconSides = new IIcon[6];
	}

	@Override public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
        return true;
    }


    // ##################################################
    //
    // Icon Methods
    //
    // ##################################################

	protected IIcon[] _iconSides;

    @SideOnly(Side.CLIENT)
	@Override public void registerBlockIcons(IIconRegister reg)
	{
        this._iconSides[0] = reg.registerIcon(this.textureName + "." + "down");
        this._iconSides[1] = reg.registerIcon(this.textureName + "." + "up");
	    for (int i = 2; i < 6; i++)
	    {
	        this._iconSides[i] = reg.registerIcon(this.textureName);
	    }
	}

    @SideOnly(Side.CLIENT)
	public IIcon getSideIcon(int side, int meta)
	{
	    return this._iconSides[side];
	}

    @SideOnly(Side.CLIENT)
	@Override public IIcon getIcon(int side, int meta)
	{
		return this.getSideIcon(side, meta);
	}

    @SideOnly(Side.CLIENT)
    @Override public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
    	int meta = blockAccess.getBlockMetadata(x, y, z);
		return this.getSideIcon(side, meta);
    }


    // ##################################################
    //
    // Power Methods
    //
    // ##################################################

    private boolean isPowered(final World world, final int x, final int y, final int z, final int xOffset, int yOffset, int zOffset)
    {
		return Block.isEqualTo(this, world.getBlock(x + xOffset, y + yOffset, z + zOffset)) && world.isBlockIndirectlyGettingPowered(x + xOffset, y + yOffset, z + zOffset);
    }

    private boolean isPowered(final World world, final int x, final int y, final int z)
    {
    	if (world.isBlockIndirectlyGettingPowered(x, y, z)) { return true; }
    	
    	if (this.isPowered(world, x, y, z, 0, 0, -1)) { return true; }
    	if (this.isPowered(world, x, y, z, 0, 0, 1)) { return true; }
    	if (this.isPowered(world, x, y, z, -1, 0, 0)) { return true; }
    	if (this.isPowered(world, x, y, z, 1, 0, 0)) { return true; }

    	if (this.isPowered(world, x, y, z, -1, 0, -1)) { return true; }
    	if (this.isPowered(world, x, y, z, 1, 0, 1)) { return true; }
    	if (this.isPowered(world, x, y, z, -1, 0, 1)) { return true; }
    	if (this.isPowered(world, x, y, z, 1, 0, -1)) { return true; }

    	return false;
    }


    // ##################################################
    //
    // Particle Methods
    //
    // ##################################################

    @SideOnly(Side.CLIENT)
    @Override public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
    	if (this.isPowered(world, x, y, z))
        {
        	for (int index = 0; index < 4; index++)
        	{
        		this.dripWater(world, x, y, z, random);
        	}
        	for (int index = 0; index < 4; index++)
        	{
	        	this.splashWater(world, x, y, z, random);
        	}
        }
    }

    private void dripWater(World world, int x, int y, int z, Random random)
    {
    	final float offset = 0.1F;
    	final float min = 0.0F + offset;
    	final float max = 0.9F + offset;

    	final double xParticle = x + this.getFloat(min, max, random);
    	final double yParticle = y;
    	final double zParticle = z + this.getFloat(min, max, random);
        world.spawnParticle("dripWater",
        		xParticle, yParticle, zParticle,
        		0.0D, 0.0D, 0.0D);
    }

    private void splashWater(World world, int x, int y, int z, Random random)
    {
    	final float offset = 0.1F;
    	final float min = 0.0F + offset;
    	final float max = 0.9F + offset;

    	final double xParticle = x + this.getFloat(min, max, random);
    	final double zParticle = z + this.getFloat(min, max, random);
    	//final double yParticle = y - 1;
    	double yParticle = -1;
    	for (int index = 1; index < 6; index++)
    	{
    		int yCheck = y - index;
    		if (yCheck < 1) { break; }
    		if (world.isSideSolid(x, yCheck, z, ForgeDirection.UP))
    		{
    			yParticle = yCheck + 1.5F;
    			break;
    		}
    	}
    	
    	if (yParticle > 0)
    	{
	        world.spawnParticle("splash",
	        		xParticle, yParticle, zParticle,
	        		0.0D, 0.0D, 0.0D);
    	}
    }
    
    private float getFloat(final float min, final float max, final Random random)
    {
    	return min + ((max - min) * random.nextFloat());
    }
}
