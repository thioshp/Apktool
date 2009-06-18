/*
 * [The "BSD licence"]
 * Copyright (c) 2009 Ben Gruver
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jf.baksmali.Adaptors;

import org.jf.dexlib.AnnotationItem;
import org.jf.baksmali.Adaptors.EncodedValue.AnnotationEncodedValueAdaptor;
import org.jf.baksmali.Adaptors.Reference.TypeReference;

import java.util.List;

public class AnnotationAdaptor {
    private AnnotationItem annotationItem;
    private AnnotationEncodedValueAdaptor encodedAnnotationAdaptor;

    public AnnotationAdaptor(AnnotationItem annotationItem) {
        this.annotationItem = annotationItem;
        this.encodedAnnotationAdaptor = new AnnotationEncodedValueAdaptor(annotationItem.getEncodedAnnotation());
    }

    public String getVisibility() {
        switch (annotationItem.getVisibility()) {
            case 0:
                return "build";
            case 1:
                return "runtime";
            case 2:
                return "system";
        }
        return null;
    }

    public TypeReference getAnnotationType() {
        return encodedAnnotationAdaptor.getAnnotationType();
    }

    public List<AnnotationEncodedValueAdaptor.AnnotationElementAdaptor> getElements() {
        return encodedAnnotationAdaptor.getElements();
    }
}
