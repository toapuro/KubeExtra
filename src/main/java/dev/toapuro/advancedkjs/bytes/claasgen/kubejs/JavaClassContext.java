package dev.toapuro.advancedkjs.bytes.claasgen.kubejs;

import dev.toapuro.advancedkjs.bytes.claasgen.construction.GenAnnotation;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;

import java.util.ArrayList;
import java.util.List;

public class JavaClassContext {
    private final CtClass ctClass;
    private final ClassFile classFile;
    private final ConstPool constPool;
    private final List<GenAnnotation> annotations;

    public JavaClassContext(ConstPool constPool, ClassFile classFile, CtClass ctClass) {
        this.constPool = constPool;
        this.classFile = classFile;
        this.ctClass = ctClass;
        this.annotations = new ArrayList<>();
    }

    public void addAnnotation(GenAnnotation annotation) {
        this.annotations.add(annotation);
    }

    public void buildAnnotations() {
        AnnotationsAttribute attribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        for (GenAnnotation annotation : this.annotations) {
            attribute.addAnnotation(annotation.compileAnnotation(constPool));
        }
        classFile.addAttribute(attribute);
    }

    public CtClass getCtClass() {
        return ctClass;
    }

    public ClassFile getClassFile() {
        return classFile;
    }

    public ConstPool getConstPool() {
        return constPool;
    }
}
