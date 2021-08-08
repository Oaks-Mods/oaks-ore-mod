package org.oakbricks.oakores.util;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import org.oakbricks.oakores.OakOres;

public class OakOresTags {
    public static final RuleTest LEAD_POISONING_BLOCKS;
    static {
        LEAD_POISONING_BLOCKS = new TagMatchRuleTest(OakOres.LEAD_POISONING_BLOCKS);
    }
}
