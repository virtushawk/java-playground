#include <jni.h>        // JNI header provided by JDK
#include "com_virtushawk_app_jni_JNIApplication.h"   // Generated

// Implementation of the native method
JNIEXPORT jint JNICALL Java_com_virtushawk_app_jni_JNIApplication_sum(JNIEnv *env, jobject thisObj, jint x, jint y) {
   return x + y;
}