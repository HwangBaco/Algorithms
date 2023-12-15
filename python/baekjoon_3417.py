"""Coded By chatGPT"""

import sys
input = sys.stdin.readline
def vigenere_encrypt(plaintext, key):
    """Encrypts a plaintext message using the Vigenère cipher with a given key"""
    ciphertext = ""
    key_index = 0
    for letter in plaintext:
        if letter.isalpha():
            # Shift the plaintext letter forward by the corresponding key letter
            shift = ord(key[key_index % len(key)].upper()) - ord('A') + 1
            ciphertext += chr((ord(letter.upper()) - ord('A') + shift) % 26 + ord('A'))
            key_index += 1
        else:
            # Non-alphabetic characters are ignored and not encrypted
            ciphertext += letter
    return ciphertext
while 1:
    key = input()
    if key == '0': break
    plaintext = input()
    ciphertext = vigenere_encrypt(plaintext, key)
    print(ciphertext)
