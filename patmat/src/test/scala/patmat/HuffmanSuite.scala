package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times for some chars list") {
    val frequencies = times(List('a', 'b', 'a', 'a', 'c', 'c', 'd', 'a'))
    frequencies.foreach {
      case ('a', num) => assert(num === 4)
      case ('b', num) => assert(num === 1)
      case ('c', num) => assert(num === 2)
      case ('d', num) => assert(num === 1)
    }
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("singleton for some code tree list") {
    assert(singleton(Nil) === false)
    assert(singleton(List(Leaf('a', 1))) === true)
    assert(singleton(List(Leaf('a', 1), Leaf('b', 2))) === false)
  }

  test("combine of some leaf list") {
    val leaflist1 = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist1) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
    val leaflist2 = List(Leaf('e', 2), Leaf('t', 3), Leaf('x', 4))
    assert(combine(leaflist2) === List(Leaf('x', 4), Fork(Leaf('e', 2), Leaf('t', 3), List('e', 't'), 5)))
  }

  test("createCodTree of some char list") {
    val string = "texxtxx"
    assert(createCodeTree(string2Chars(string)) === Fork(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4), List('e', 't', 'x'), 7))
  }

  test("decode some secret") {
    println(decodedSecret)
  }

  test("encode some text") {
    new TestTrees {
      assert(encode(t1)("ab".toList) === List(0, 1))
      assert(encode(t2)("abd".toList) === List(0, 0, 0, 1, 1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
      assert(decode(t2, encode(t2)("abd".toList)) === "abd".toList)
    }
  }

  test("codeBits some text") {
    val codeTable = List(('a', List(0, 1)), ('b', List(1)), ('c', List(0, 0)))
    assert(codeBits(codeTable)('a') === List(0, 1))
    assert(codeBits(codeTable)('b') === List(1))
    assert(codeBits(codeTable)('c') === List(0, 0))
  }

  test("convert some code tree to code table") {
    new TestTrees {
      println(convert(t1))
      println(convert(t2))
    }
  }

  test("quickEncode some text") {
    new TestTrees {
      assert(quickEncode(t1)("ab".toList) === List(0, 1))
      assert(quickEncode(t2)("abd".toList) === List(0, 0, 0, 1, 1))
    }
  }
}
