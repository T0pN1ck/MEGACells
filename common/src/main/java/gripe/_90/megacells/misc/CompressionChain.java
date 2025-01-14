package gripe._90.megacells.misc;

import java.math.BigInteger;
import java.util.Collections;
import java.util.stream.Collectors;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import appeng.api.stacks.AEItemKey;

import gripe._90.megacells.definition.MEGAConfig;

public class CompressionChain extends ObjectArrayList<CompressionService.Variant> {
    public void add(AEItemKey item, byte factor) {
        this.add(new CompressionService.Variant(item, factor));
    }

    public boolean containsVariant(AEItemKey item) {
        return this.stream().anyMatch(v -> v.item().equals(item));
    }

    public BigInteger unitFactor(AEItemKey item) {
        var variant = this.stream().filter(v -> v.item().equals(item)).findFirst();

        if (variant.isEmpty()) {
            return BigInteger.ONE;
        }

        var subChain = this.subList(0, indexOf(variant.get()) + 1);
        return subChain.stream().map(v -> BigInteger.valueOf(v.factor())).reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public CompressionChain lastMultiplierSwapped() {
        var multipliers = this.stream().map(CompressionService.Variant::factor).collect(Collectors.toList());
        Collections.rotate(multipliers, -1);

        var items = this.stream().map(CompressionService.Variant::item).toList();
        var chain = new CompressionChain();

        for (var i = 0; i < items.size(); i++) {
            chain.add(items.get(i), multipliers.get(i));
        }

        return chain;
    }

    public CompressionChain limited() {
        var chainLength = MEGAConfig.INSTANCE.getCompressionChainLimit();

        if (size <= chainLength) {
            return this;
        }

        var chain = new CompressionChain();
        chain.addAll(this.subList(0, chainLength));
        return chain;
    }

    public CompressionChain reversed() {
        var chain = new CompressionChain();

        for (var i = size - 1; i >= 0; i--) {
            chain.add(this.get(i));
        }

        return chain;
    }
}
