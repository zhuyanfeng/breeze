package breeze.linalg.operators
/*
 Copyright 2012 David Hall

 Licensed under the Apache License, Version 2.0 (the "License")
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
import collection.mutable.HashMap
import breeze.generic.{MethodImpl, Multimethod}
import breeze.math.Ring

/**
 * This is the capability trait for operations of the form -a.
 * These traits are usually implemented in (a supertype of) the companion object of
 * one of the operands.
 * @tparam A
 * @tparam Op
 */
trait UnaryOp[A, Op <: OpType, +R] {
  def apply(a: A): R
}

object UnaryOp {
  implicit def scalaOpNeg[S:Ring]: UnaryOp[S, OpNeg, S] = new UnaryOp[S, OpNeg, S] {
    def apply(a: S): S = implicitly[Ring[S]].negate(a)
  }

}


