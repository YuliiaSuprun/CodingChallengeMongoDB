package main.rice.basegen;

import main.rice.node.APyNode;
import main.rice.obj.APyObj;
import main.rice.test.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseSetGenerator {
    private List<APyNode<?>> nodes;
    private int numRand;

    public BaseSetGenerator(List<APyNode<?>> nodes, int numRand) {
        this.nodes = nodes;
        this.numRand = numRand;
    }

    public List<TestCase> genBaseSet() {
        return new ArrayList<>(this.addRandTests(this.genExTests()));
    }

    public Set<TestCase> genExTests() {
        Set<List<APyObj>> exArgs = new HashSet<>();
        exArgs.add(new ArrayList<>());
        for (APyNode<?> node : this.nodes) {
            Set<List<APyObj>> newExArgs = new HashSet<>();
            for (APyObj genObj : node.genExVals()) {
                for (List<APyObj> args : exArgs) {
                    List<APyObj> newArgs = new ArrayList<>(args);
                    newArgs.add(genObj);
                    newExArgs.add(newArgs);
                }
            }
            exArgs = newExArgs;
        }
        Set<TestCase> exTests = new HashSet<>();
        for (List<APyObj> args : exArgs) {
            exTests.add(new TestCase(args));
        }
        return exTests;
    }

    public Set<TestCase> genRandTests() {
        return this.addRandTests(new HashSet<>());
    }

    private Set<TestCase> addRandTests(Set<TestCase> exTests) {
        Set<List<APyObj>> exArgs = new HashSet<>();
        for (TestCase test : exTests) {
            exArgs.add(test.getArgs());
        }
        int count = 0;
        while (count < this.numRand) {
            List<APyObj> args = new ArrayList<>();
            for (APyNode<?> node : this.nodes) {
                args.add(node.genRandVal());
            }
            if (!exArgs.contains(args)) {
                exArgs.add(args);
                count++;
            }
        }
        Set<TestCase> newTests = new HashSet<>();
        for (List<APyObj> args : exArgs) {
            newTests.add(new TestCase(args));
        }
        return newTests;
    }
}
