package com.example.headportrait.net;

/**
 * @Creation date
 * @name
 * @Class action
 */

public interface OnNetListener<T> {
void onSuccess(T t);
void onFaile(Exception e);


}
