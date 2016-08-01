package com.aedan.ai.correlationai;

/**
 * The exception thrown when an error occurs while calculating a Neuron's effect.
 */

public class UnavailableNeuronEffectException extends Exception {

    public UnavailableNeuronEffectException(String message){
        super(message);
    }

}