package com.cicko.weatheraoplication.domain

public interface Command<out T>{
    fun execute() : T
}