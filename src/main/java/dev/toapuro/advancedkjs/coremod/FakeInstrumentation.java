package dev.toapuro.advancedkjs.coremod;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;

public class FakeInstrumentation implements Instrumentation {
    private final List<ClassFileTransformer> transformers;

    public FakeInstrumentation() {
        this.transformers = new ArrayList<>();
    }

    @Override
    public void addTransformer(ClassFileTransformer transformer, boolean canRetransform) {
        transformers.add(transformer);
    }

    @Override
    public void addTransformer(ClassFileTransformer transformer) {
        transformers.add(transformer);
    }

    @Override
    public boolean removeTransformer(ClassFileTransformer transformer) {
        return false;
    }

    @Override
    public boolean isRetransformClassesSupported() {
        return false;
    }

    @Override
    public void retransformClasses(Class<?>... classes) throws UnmodifiableClassException {

    }

    @Override
    public boolean isRedefineClassesSupported() {
        return false;
    }

    @Override
    public void redefineClasses(ClassDefinition... definitions) throws ClassNotFoundException, UnmodifiableClassException {

    }

    @Override
    public boolean isModifiableClass(Class<?> theClass) {
        return false;
    }

    @Override
    public Class<?>[] getAllLoadedClasses() {
        return new Class[0];
    }

    @Override
    public Class<?>[] getInitiatedClasses(ClassLoader loader) {
        return new Class[0];
    }

    @Override
    public long getObjectSize(Object objectToSize) {
        return 0;
    }

    @Override
    public void appendToBootstrapClassLoaderSearch(JarFile jarfile) {

    }

    @Override
    public void appendToSystemClassLoaderSearch(JarFile jarfile) {

    }

    @Override
    public boolean isNativeMethodPrefixSupported() {
        return false;
    }

    @Override
    public void setNativeMethodPrefix(ClassFileTransformer transformer, String prefix) {

    }

    @Override
    public void redefineModule(Module module, Set<Module> extraReads, Map<String, Set<Module>> extraExports, Map<String, Set<Module>> extraOpens, Set<Class<?>> extraUses, Map<Class<?>, List<Class<?>>> extraProvides) {

    }

    @Override
    public boolean isModifiableModule(Module module) {
        return false;
    }

    public List<ClassFileTransformer> getTransformers() {
        return transformers;
    }
}
